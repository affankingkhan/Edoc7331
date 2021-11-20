//https://binarysearch.com/problems/Set
class CustomSet {
    constructor() {
        this.arr = new Array(1000);
    }

    add(val) {
        let idx = val % 1000;
        if (this.arr[idx]) {
            this.addValToArray(this.arr[idx], val);
        } else {
            this.arr[idx] = [val];
        }
    }

    addValToArray(arr, val) {
        for (let num of arr) {
            if (num == val) return;
        }
        arr.push(val);
    }

    findVal(arr, val) {
        const found = arr.find(el => el === val)
        return Boolean(found);
    }

    exists(val) {
        let idx = val % 1000;
        return this.findVal(this.arr?.[idx] ?? [], val);
    }

    remove(val) {
        let idx = val % 1000;
        if (this.arr[idx]) {
            this.arr[idx] = this.arr[idx].filter(el => el !== val);
        }
    }
}