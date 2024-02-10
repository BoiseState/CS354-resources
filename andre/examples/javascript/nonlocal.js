function a() {
    function c() {
        function e() { console.log("you are here!"); }
        function d() { e(); }
        d();
    }

    function b() { c(); }
    b();
}

a();