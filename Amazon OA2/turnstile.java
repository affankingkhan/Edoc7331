public static int[] Turnstile (int[]directions, int[]times)
  {
    int n = directions.length;
        int[] ret = new int[n];

        ArrayDeque<int[]> enter = new ArrayDeque<>();
        ArrayDeque<int[]> exit = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (directions[i] == 0) {
                enter.offer(new int[] {i, times[i]});

            } else {
                exit.offer(new int[] {i, times[i]});
            }
        }

        int time = 0;
        int dir = 1;

        while (!enter.isEmpty() && !exit.isEmpty()) {
            int[] currExit = exit.peek();
            int[] currEnter = enter.peek();
            // only jump time if both at front have not arrived by time
            if (currExit[1] > time && currEnter[1] > time) {
                time = Math.min(currExit[1], currEnter[1]);
                dir = 1;
            }

            if (dir == 1 && currExit[1] <= time) {
                ret[currExit[0]] = time;
                exit.poll();
            } else if (dir == 1 && currExit[1] > time) {
                ret[currEnter[0]] = time;
                dir = 0;
                enter.poll();
            }

            else if (dir == 0 && currEnter[1] <= time) {
                ret[currEnter[0]] = time;
                enter.poll();
            } else if (dir == 0 && currEnter[1] > time) {
                ret[currExit[0]] = time;
                dir = 1;
                exit.poll();
            }
            time++;
        }

        while (!enter.isEmpty()) {
            int[] currEnter = enter.peek();
            if (time < currEnter[1])
                time = currEnter[1];
            ret[currEnter[0]] = time;
            enter.poll();
            time++;
        }

        while (!exit.isEmpty()) {
            int[] currExit = exit.peek();
            if (time < currExit[1])
                time = currExit[1];
            ret[currExit[0]] = time;
            exit.poll();
            time++;
        }

        return ret;

  }