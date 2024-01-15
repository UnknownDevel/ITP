package ITP8;

public class Main {
    public static void main(String[] args){
        DataManager dataManager = new DataManager();
        dataManager.registerDataProcessor(new Filterprocessor());
        dataManager.registerDataProcessor(new TransformProcessor());
        dataManager.registerDataProcessor(new Aggregateprocessor());

        dataManager.loadData("ITP8/source.txt");
        dataManager.processData();
        dataManager.savedata("ITP8/destination.txt");
    }
}
