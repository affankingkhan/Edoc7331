//https://binarysearch.com/problems/Stock-Span
class StockSpan {
    stack: Array<Array<number>>;
    idx: number;

    constructor() {
        this.stack = [];
        this.idx = 0;
    }

    next(price: number): number {
        while (this.stack.length && this.stack[this.stack.length - 1][0] <= price) {
            this.stack.pop();
        }
        let ans = !this.stack.length ? this.idx : this.idx - this.stack[this.stack.length - 1][1];
        this.stack.push([price, ++this.idx]);
        return ans + 1;
    }
}