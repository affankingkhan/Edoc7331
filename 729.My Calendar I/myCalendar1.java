class MyCalendar {
    class MyEvent{
        int start;
        int end;
        
        MyEvent(int s, int e){
            this.start = s;
            this.end = e;
        }
    }
    List<MyEvent> events;

    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        int left = 0;
        int right = events.size() -1;
        
        // binary search
        while(left <= right){
            // get middle event
            int m = (left  + right) / 2;
            MyEvent midEvent = events.get(m);
            
            // check if the new event would overlap with the middle event, if it does, return false
            if((start <= midEvent.start && end > midEvent.start) || (start < midEvent.end && start >= midEvent.start)) return false;
            
            // if it ends before or when the middle starts, we know its before so change right to m-1
            if(end <= midEvent.start) {
                right = m - 1;
            }
            
            // if it starts after or when the middle ends, we know its after so change left to m+1
            else if (start >= midEvent.end){
                left = m + 1;
            }
            
        }
        
        
        // when left is greater than right, add the new Event to the left index.
        // we could potentially be adding it to the end of the list too which would be the index marked left
        events.add(left, new MyEvent(start, end));
        return true;

    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */