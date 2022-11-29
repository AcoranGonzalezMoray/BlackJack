package model;

 public enum Card {
        _2, _3, _4, _5, _6, _7, _8, _9, _10, Jack, Queen, King, Ace;

        public boolean isFace() {
            return this == Jack || this == Queen || this == King;            
        }
        
        public boolean isAce() {
            return this == Ace;
        }

        public int value() {
            if (isAce()) return 11;
            if (isFace()) return 10;
            return ordinal() + 2;
        }
        
}    