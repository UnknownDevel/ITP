package ITP8;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataManager{
    private List<Object> dataProcessors;
    private List<String> data;
    private List<String> processedData;

    public DataManager(){
        this.dataProcessors = new ArrayList<>();
        this.processedData = new ArrayList<>();
    }
    
    public void registerDataProcessor(Object processor){
        this.dataProcessors.add(processor);
    }

    public void loadData(String src){
        try{
            this.data = Files.readAllLines(Paths.get(src));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void processData(){
        processedData.clear();
        List<String> tdata = new ArrayList<>(data);

        CompletableFuture<Void> filterfuture = CompletableFuture.runAsync(() -> {
            try{
                System.out.println("Filtering data...");
                List<String> fdata = applyDataProcessor(new Filterprocessor(), tdata);
                tdata.clear();
                tdata.addAll(fdata);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        });
        CompletableFuture<Void> transformfuture = filterfuture.thenRunAsync(() -> {
            try{
                System.out.println("Transforming data...");
                List<String> fdata = applyDataProcessor(new TransformProcessor(), tdata);
                tdata.clear();
                tdata.addAll(fdata);
            } catch(Exception e){
                e.printStackTrace();
            }
        });
        CompletableFuture<Void> aggregatefuture = transformfuture.thenRunAsync(() -> {
            try{
                System.out.println("Aggregating data...");
                String fdata = applyDataProcessor(new Aggregateprocessor(), tdata).get(0);
                tdata.clear();
                processedData.add(fdata);
            } catch (Exception e){
                e.printStackTrace();
            }
        });
        CompletableFuture all = CompletableFuture.allOf(filterfuture, transformfuture, aggregatefuture);
        try{
            all.get();
        } catch(InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }
    private List<String> applyDataProcessor(Object processor, List<String> inputData){
        if (processor instanceof Filterprocessor){
            return ((Filterprocessor) processor).filterData(inputData);
        } else if(processor instanceof TransformProcessor){
            return((TransformProcessor) processor).transformData(inputData);
        } else if(processor instanceof Aggregateprocessor){
            return List.of(((Aggregateprocessor) processor).aggregateData(inputData));
        } else{
            System.out.println("Error: This processor does not exist");
            return new ArrayList<String>();
        }
    }
    public void savedata(String destination){
        try{
            String processedDataString = String.join("\n", processedData);
            Files.write(Paths.get(destination), processedDataString.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}