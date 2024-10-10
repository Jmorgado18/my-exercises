package io.CodeForAll.fanstatics;

public class GrumpyGenie extends Genie {
        private int nrOfWishes;
        String genieEmoji = "\uD83E\uDDDE\u200D♀\uFE0F";
        public GrumpyGenie(int nrOfWishes) {
                super(nrOfWishes);

        }

        @Override
        public void doWish() {

                System.out.println("Your wish has been granted. MUAAHAHAH - you only have one " +genieEmoji);
                System.out.println("===========================================");

                }

        }
