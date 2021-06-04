class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // sort the deck
        Arrays.sort(deck);
        int m = deck.length;
        
        int j = 0;
        int[] ret = new int[deck.length];
        boolean adding = true;
        
        // loop through each card in ascending order
        for(int i = 0; i < deck.length; i++){
            //card i want to add next
            int card = deck[i];
            // keep running until a card is added
            while(true){
                // if the current index is not = 0, we have already places a card there so increment j
                if(ret[j % m] != 0){
                    j++;
                }else{
                    // if adding, then we add the card
                    // else we are skipping, so we skip the card
                    // alternate adding and skipping between empty spot finds in ret array
                    if(adding){
                        ret[j % m] = card;
                        adding = false;
                        j++;
                        break;
                          
                    }else{
                        adding = true;
                        j++;
                    }
                    
                }
            }
  
        }
        
        return ret;

    }
}