
interface CloudHostingProvider {
    void createServer(String region);
    void listServers(String region);
}

interface CDNProvider {
    String getCDNAddress();
}

interface CloudStorageProvider {
    void storeFile(String name);
    void getFile(String name);
}

class Amazon implements CloudHostingProvider, CDNProvider, CloudStorageProvider {

    @Override
    public void storeFile(String name) {
        System.out.println("Amazon storing file: " + name);
    }

    @Override
    public void getFile(String name) {
        System.out.println("Amazon retrieving file: " + name);
    }

    @Override
    public void createServer(String region) {
        System.out.println("Amazon creating server in region: " + region);
    }

    @Override
    public void listServers(String region) {
        System.out.println("Amazon listing servers in region: " + region);
    }

    @Override
    public String getCDNAddress() {
        return "Amazon CDN Address: cdn.amazon.com";
    }
}

class Dropbox implements CloudStorageProvider {

    @Override
    public void storeFile(String name) {
        System.out.println("Dropbox storing file: " + name);
    }

    @Override
    public void getFile(String name) {
        System.out.println("Dropbox retrieving file: " + name);
    }
}

public class amazon {
    public static void main(String[] args) {

        System.out.println("=== Amazon Cloud Services ===");
        Amazon amazon = new Amazon();
        amazon.storeFile("project.zip");
        amazon.getFile("report.pdf");
        amazon.createServer("US-East");
        amazon.listServers("US-East");
        System.out.println(amazon.getCDNAddress());

        System.out.println("\n=== Dropbox Cloud Storage ===");
        Dropbox dropbox = new Dropbox();
        dropbox.storeFile("assignment.docx");
        dropbox.getFile("notes.txt");
    }
}

