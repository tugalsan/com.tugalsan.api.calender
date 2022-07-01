module com.tugalsan.api.calender {
    requires com.sun.jna;
    requires com.sun.jna.platform;
    requires com.tugalsan.api.unsafe;
    requires com.tugalsan.api.cast;
    requires com.tugalsan.api.string;
    requires com.tugalsan.api.pack;
    exports com.tugalsan.api.calender.client;
    exports com.tugalsan.api.calender.server;
}
