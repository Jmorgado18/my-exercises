package io.CodeForAll.fanstatics;

public class GrumpyGenie extends Genie {
        private int nrOfWishes;

        public GrumpyGenie(int nrOfWishes) {
                super();
                this.nrOfWishes = nrOfWishes;
        }

        public void doWish() {

                System.out.println("Your wish has been granted. MUAAHAHAH - you only have one");
                System.out.println("===========================================");

                }

        }
