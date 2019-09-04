package domain;
    public class Barcode {

    	/* Domain Model: Instance variables */
        private String TransponderData;
        private String EPC;

        public Barcode(String transponderData, String EPC) {
            TransponderData = transponderData;
            this.EPC = EPC;
        }

        /* Getters */
        public String getTransponderData() {
        	return TransponderData;
        }
        
        public String getEPC() {
        	return EPC;
        }
    }