import React from 'react';
import styles from '../StyleSheets/CohortDetails.module.css';

const cohortData = [
  {
    code: 'INTADMDF10',
    title: '.NET FSD',
    startDate: '22-Feb-2022',
    status: 'Scheduled',
    coach: 'Aathma',
    trainer: 'Jojo Jose'
  },
  {
    code: 'ADM21JF014',
    title: 'Java FSD',
    startDate: '10-Sep-2021',
    status: 'Ongoing',
    coach: 'Apoorv',
    trainer: 'Elisa Smith'
  },
  {
    code: 'CDBJF21025',
    title: 'Java FSD',
    startDate: '24-Dec-2021',
    status: 'Ongoing',
    coach: 'Aathma',
    trainer: 'John Doe'
  }
];

const CohortsDetails = () => {
  return (
    <div>
      <h2 className={styles.header}>Cohorts Details</h2>
      <div className={styles.grid}>
        {cohortData.map((c) => (
          <div key={c.code} className={styles.card}>
            <h3 className={styles.title}>
              <span className={styles.code}>{c.code} </span>– {c.title}
            </h3>
            <p><strong>Started On</strong><br />{c.startDate}</p>
            <p><strong>Current Status</strong><br />{c.status}</p>
            <p><strong>Coach</strong><br />{c.coach}</p>
            <p><strong>Trainer</strong><br />{c.trainer}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default CohortsDetails;
