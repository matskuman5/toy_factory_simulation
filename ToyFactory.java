public class ToyFactory {

    private int fursInStock = 0;
    private int fillingsInStock = 0;
    private int nosesInStock = 0;
    private int eyesInStock = 0;

    private int toysFinished = 0;

    public int getToysFinished() {
        return toysFinished;
    }

    public ToyFactory() {
    }

    @Override
    public String toString() {
        return "ToyFactory [fursInStock=" + fursInStock + ", fillingsInStock=" + fillingsInStock + ", nosesInStock="
                + nosesInStock + ", eyesInStock=" + eyesInStock + ", toysFinished=" + toysFinished + "]";
    }

}