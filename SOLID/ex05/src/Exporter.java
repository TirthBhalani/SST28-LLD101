public abstract class Exporter 
{
    public final ExportResult export(ExportRequest req) 
    {
        if (req == null) {
            throw new NullPointerException("ExportRequest cannot be null");
        }
        if (req.title == null) {
            throw new NullPointerException("ExportRequest.title cannot be null");
        }
        if (req.body == null) {
            throw new NullPointerException("ExportRequest.body cannot be null");
        }

        return doExport(req);
    }

    protected abstract ExportResult doExport(ExportRequest req);

    // why this keywrd ? 
        //taki only subclasses can see this method. external users isko call nahi kar sakte.
}
// Ye base class clear preconditions enforce karta hai aur common contract define karta hai, taaki sab subclasses same rules follow kare aur true substitutability maintain ho (core LSP)