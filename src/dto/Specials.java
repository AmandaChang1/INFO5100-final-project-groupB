package dto;

import java.util.ArrayList;



    public class Specials {

        private ArrayList<Special> specials = new ArrayList<>();


        public ArrayList<Special> getSpecials() {
            return this.specials;
        }

        public void addSpecials(Special s) {
            this.specials.add(s);
        }
        public int getNumberOfSpecials() {
            return getSpecials().size();
        }
    }

