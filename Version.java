public class Version {
        private int[] info;
        public Version() {
                info = new int[4];
                upd(0);
        }
        public String getReadable() {
                String s = "v" ;
                for (int i = 0; i<4; i++) 
                        s+=info[i]+(i<3? ".": "");
                return s;
        }
        public void updMajorV()         {upd(0);}
        public void updMinorV()         {upd(1);}
        public void updBugFixRelease()  {upd(2);}
        public void updBuildNumber()    {upd(3);}
        private void upd(int a) {
                info[a]++;
                if (a==0) 
                        for(int i = 1; i<4; i++) 
                                info[i] = 0;
        }
}
