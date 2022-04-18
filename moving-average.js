class MovingAverage {
    constructor(arrNum) {
        this.arr = [];
        this.arrNum = arrNum;
    }
    
    next(num) {
        var avg = 0;
        if(this.arr.length < this.arrNum) {
            this.arr.push(num);
            avg = this.findAvg();
        }
        else {
            this.arr.shift();
            this.arr.push(num);
            avg = this.findAvg();
        }
        console.log(avg.toFixed(1));
    }
    
    findAvg() {
        var average = 0, tot = 0;
        for(var i=0; i<this.arr.length; i++)
            tot += this.arr[i];
        return average = tot / this.arr.length;
    }
}

var m = new MovingAverage(3);

m.next(1);
m.next(10);
m.next(3);
m.next(5);
