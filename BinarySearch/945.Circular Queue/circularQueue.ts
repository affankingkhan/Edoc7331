//https://binarysearch.com/problems/Circular-Queue
class CircularQueue {
    capacity: number;
    queue: Array<number>;
    size: number;
    start: number;
    end: number;

    constructor(capacity: number) {
        this.capacity = capacity;
        this.queue = new Array(capacity);
        this.size = 0;
        this.start = 0;
        this.end = 0;

    }

    enqueue(val: number): boolean {
        if (this.isFull()) return false;

        this.queue[this.end++] = val;
        this.size++;
        this.end %= this.capacity;
        return true;
    }

    dequeue(): boolean {
        if (this.isEmpty()) return false;

        delete this.queue[this.start++];
        this.size--;
        this.start %= this.capacity;
        return true;
    }

    front(): number {
        if (this.isEmpty()) return -1;

        return this.queue[this.start];

    }

    top(): number {
        if (this.isEmpty()) return -1;

        let idx = this.end - 1;
        if (idx < 0) {
            idx = this.capacity - 1;
        }
        return this.queue[idx];

    }

    isFull(): boolean {
        return this.size === this.capacity;

    }

    isEmpty(): boolean {
        return this.size === 0;

    }
}