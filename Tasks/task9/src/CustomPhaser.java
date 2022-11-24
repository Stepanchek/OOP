public class CustomPhaser {
    private int parties;
    private Integer partiesAwait;
    private int phase;

    public CustomPhaser(){
        parties = 0;
        partiesAwait = 0;
        phase = 0;
    }

    public CustomPhaser(int parties){
        this.parties = parties;
        this.partiesAwait = parties;
    }

    int register(){
        ++parties;
        ++partiesAwait;
        return phase;
    }

    int arrive(){
        --partiesAwait;
        int currPhase = phase;
        synchronized (this){
            if(partiesAwait == 0){
                notifyAll();
                partiesAwait = parties;
                phase = currPhase + 1;
            }
        }
        return phase;
    }

    int arriveAndAwaitAdvance(){
        --partiesAwait;
        int currPhase = phase;
        synchronized (this){
            while (partiesAwait > 0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        partiesAwait = parties;
        phase = currPhase + 1;
        synchronized (this){
            notifyAll();
        }
        return phase;
    }

    int arriveAndDeregister() {
        --partiesAwait;
        --parties;
        int currPhase = phase;
        synchronized (this) {
            if (partiesAwait == 0) {
                notifyAll();
                phase = currPhase + 1;
                partiesAwait = parties;
                return -1;
            }
        }
        return phase + 1;
    }

    int getPhase() {
        return phase;
    }
}
