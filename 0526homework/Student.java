import java.io.Serializable;

public class Student implements Serializable{
        public Student (String s, short e, short m, short j){
            name = s;
            EScore = e;
            MScore = m;
            JScore = j;
        }
        public Student (){}
        public String getN (){return name;}
        public short getE (){return EScore;}
        public short getM (){return MScore;}
        public short getJ (){return JScore;}

        public double getAvg(){
            return (EScore+MScore+JScore)/3.0;
        }
        
        private String name;
        private short EScore;
        private short MScore;
        private short JScore;
    }
