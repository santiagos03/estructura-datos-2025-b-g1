import java.time.LocalDate;
import java.util.Scanner;

public class BibliotecaApp {
    static final int MAX=30, SUC=3;
    static Libro[] libros=new Libro[MAX];
    static int[][] disp=new int[MAX][SUC];
    static PrestamoList prestamos=new PrestamoList();
    static Historial historial=new Historial();
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args){
        demo();
        while(true){
            menu(); String op=sc.nextLine();
            switch(op){
                case "1": alta(); break;
                case "2": baja(); break;
                case "3": buscarTitulo(); break;
                case "4": prestar(); break;
                case "5": devolver(); break;
                case "6": listarPrestamos(); break;
                case "7": historial.fwd(); break;
                case "8": historial.bwd(); break;
                case "9": listar(); break;
                case "0": return;
            }
        }
    }

    static void menu(){
        System.out.println("1-Alta  2-Baja  3-BuscarTitulo  4-Prestar  5-Devolver  6-Prestamos  7-Hist(Fwd)  8-Hist(Bwd)  9-Catalogo  0-Salir");
        System.out.print("> ");
    }

    static void alta(){
        System.out.print("Codigo: "); int c=Integer.parseInt(sc.nextLine());
        if(buscarCod(c)>=0){System.out.println("Duplicado");return;}
        System.out.print("Titulo: "); String t=sc.nextLine();
        System.out.print("Autor: "); String a=sc.nextLine();
        System.out.print("Stock: "); int s=Integer.parseInt(sc.nextLine());
        for(int i=0;i<MAX;i++) if(libros[i]==null){libros[i]=new Libro(c,t,a,s); historial.add("ALTA","Libro "+c); return;}
        System.out.println("Sin espacio");
    }

    static void baja(){
        System.out.print("Codigo: "); int c=Integer.parseInt(sc.nextLine());
        int i=buscarCod(c);
        if(i>=0 && !libros[i].baja){libros[i].baja=true; historial.add("BAJA","Libro "+c);} else System.out.println("No encontrado");
    }

    static void buscarTitulo(){
        System.out.print("Titulo: "); String q=sc.nextLine().toLowerCase();
        for(Libro l:libros) if(l!=null && l.titulo.toLowerCase().contains(q)) {System.out.println(l);return;}
        System.out.println("No hallado");
    }

    static void prestar(){
        System.out.print("Codigo: "); int c=Integer.parseInt(sc.nextLine());
        int i=buscarCod(c); if(i<0||libros[i].baja||libros[i].stock<=0){System.out.println("No disponible");return;}
        System.out.print("Usuario: "); String u=sc.nextLine();
        System.out.print("Sucursal 0.."+(SUC-1)+": "); int s=Integer.parseInt(sc.nextLine());
        if(disp[i][s]<=0){System.out.println("Sin stock en sucursal");return;}
        prestamos.add(new Prestamo(c,u)); disp[i][s]--; libros[i].stock--;
        historial.add("PRESTAMO","Libro "+c+" a "+u);
    }

    static void devolver(){
        System.out.print("Codigo: "); int c=Integer.parseInt(sc.nextLine());
        System.out.print("Usuario: "); String u=sc.nextLine();
        System.out.print("Sucursal: "); int s=Integer.parseInt(sc.nextLine());
        if(prestamos.remove(c,u)){int i=buscarCod(c);disp[i][s]++;libros[i].stock++; historial.add("DEV","Libro "+c+" devuelto");}
        else System.out.println("No prestamo activo");
    }

    static void listarPrestamos(){prestamos.print();}
    static void listar(){for(Libro l:libros) if(l!=null) System.out.println(l);}

    static int buscarCod(int c){for(int i=0;i<MAX;i++) if(libros[i]!=null&&libros[i].codigo==c) return i; return -1;}

    static void demo(){
        libros[0]=new Libro(1,"Java","Autor A",3); disp[0][0]=1;disp[0][1]=1;disp[0][2]=1;
        libros[1]=new Libro(2,"EDatos","Autor B",2); disp[1][0]=1;disp[1][1]=1;
        historial.add("ALTA","Libros demo");
    }

    /* ======== Clases ======== */
    static class Libro{
        int codigo;String titulo,autor;int stock;boolean baja=false;
        Libro(int c,String t,String a,int s){codigo=c;titulo=t;autor=a;stock=s;}
        public String toString(){return codigo+"-"+titulo+"("+autor+") stock="+stock+(baja?" [BAJA]":"");}
    }
    static class Prestamo{int cod;String usu;LocalDate f=LocalDate.now();Prestamo(int c,String u){cod=c;usu=u;} public String toString(){return cod+"-"+usu+" "+f;}}
    static class PrestamoList{
        Node h; static class Node{Prestamo d;Node n;Node(Prestamo p){d=p;}}
        void add(Prestamo p){if(h==null)h=new Node(p);else{Node c=h;while(c.n!=null)c=c.n;c.n=new Node(p);}}
        boolean remove(int c,String u){Node c1=h,p=null;while(c1!=null){if(c1.d.cod==c&&c1.d.usu.equals(u)){if(p==null)h=c1.n;else p.n=c1.n;return true;}p=c1;c1=c1.n;}return false;}
        void print(){if(h==null)System.out.println("Sin prestamos"); else{Node c=h;while(c!=null){System.out.println(c.d);c=c.n;}}}
    }
    static class Historial{
        HNode h,t; static class HNode{String tipo,desc;LocalDate f=LocalDate.now();HNode p,n;HNode(String ti,String de){tipo=ti;desc=de;}}
        void add(String tipo,String desc){HNode x=new HNode(tipo,desc); if(h==null)h=t=x;else{t.n=x;x.p=t;t=x;}}
        void fwd(){for(HNode c=h;c!=null;c=c.n)System.out.println(c.f+"-"+c.tipo+"-"+c.desc);}
        void bwd(){for(HNode c=t;c!=null;c=c.p)System.out.println(c.f+"-"+c.tipo+"-"+c.desc);}
    }
}
