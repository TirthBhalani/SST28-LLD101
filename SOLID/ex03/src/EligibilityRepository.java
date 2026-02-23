    public interface EligibilityRepository 
    {
        void save(String rollNo, String status);
    }

    // Ye interface persistence ko abstract karta hai, taaki engine ko actual storage implementation se koi direct dependency na ho (better decoupling)