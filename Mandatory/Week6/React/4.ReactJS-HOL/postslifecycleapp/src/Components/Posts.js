import React, { Component } from 'react';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }

  componentDidMount() {
    this.loadPosts();
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
      })
      .then(data => this.setState({ posts: data }))
      .catch(err => this.setState({ error: err }));
  }

  componentDidCatch(error, info) {
    alert(`An error occurred: ${error.message}`);
    this.setState({ error });
  }

  render() {
    const { posts, error } = this.state;

    if (error) {
      return <div><h2>Error loading posts.</h2></div>;
    }

    return (
      <div>
        <h1>Posts</h1>
        {posts.map(post => (
          <div key={post.id}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
