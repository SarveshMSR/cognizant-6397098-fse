public class TestFactoryMethod {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        
        System.out.println("Creating Word Document:");
        wordFactory.newDocument();
        
        System.out.println("\nCreating PDF Document:");
        pdfFactory.newDocument();
        
        System.out.println("\nCreating Excel Document:");
        excelFactory.newDocument();
    }
}
