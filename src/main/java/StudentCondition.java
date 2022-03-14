public enum StudentCondition {
    ODRABIAJACY {
        @Override public String toString() {
            return "odrabiajacy";
        }
    },
    CHORY {
        @Override public String toString() {
            return "chory";
        }
    },
    NIEOBECNY {
        @Override public String toString() {
            return "nieobecny";
        }
    },
    WYPISANY {
        @Override public String toString() {
            return "wypisany";
        }
    },
    PRZEPISANY {
        @Override public String toString() {
            return "przepisany";
        }
    },
    OCZEKUJACY {
        @Override public String toString() {
            return "oczekujacy na zapisanie";
        }
    }

}
