What changes we did:
access control, lazy loading, caching, client directly depended on concrete implementation

instead of directly creating reportFiles with new keyword, we create ReportProxy

We will move the expensive file loading logic inside the real subject that is RealReport instead of keeping it in the ReportFile

Earlier in Report file, loadFromDisk was called everytime we called the display func. Now in RealReport , it is called in the constructor and stored as content. so it will always be called only when report is generated.


