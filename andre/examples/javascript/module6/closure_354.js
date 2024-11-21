// def a(x) begin
//  x = x + 1;
//  def b(y) begin
//      var z = 3;
//      wr x + y + z
//  end
// end;
// var function = a(4);
// function(3)

const a = function(x) {
    x = x + 1;
    const b = function(y) {
        let z = 3;
        console.log(x + y + z);
    }
    return b;
}

const func = a(4);
func(3);
