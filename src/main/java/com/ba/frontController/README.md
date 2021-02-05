# Front Controller Pattern

> Front Controller tasarım örüntüsünün amacı, istekleri merkezi bir yerde karşılayıp ilgili kısıma yönlendirmektedir.

* İlgili tasarım örüntüsü, bilinen bazı framework’lerde kullanılmaktadır. Örneğin; Spring Framework’te Dispatcher Servlet olarak adlandırılır. Bir diğer örnek ise; Java Server Faces (JSF) da ise Faces Servlet olarak adlandırılır.

Somut bir örnek ile açıklayalım.

* Amacımız gönderdiğimiz işlemi karşılayıp yapılak işlemleri tek bir yerden kontrol edecek bir Dispatcher yazmak olacak.

1. Öncelikle 2 ayrı class yazalım.
&NewLine;
TeacherView

    class TeacherView {
        public void display() {
            System.out.println("Teacher View");
        }
    }

  StudentView

    class StudentView {
        public void display() {
            System.out.println("Student View");
        }
    }
* Bu sınıflarımız 2 farklı objedir.İçlerinde birbirinden farklı fonksiyonlar olabilir.

2. Dispatcing sınıfımızı oluşturalım.
&NewLine;
Dispatching

    class Dispatching {
        private StudentView studentView;
        private TeacherView teacherView;

        public Dispatching() {
            studentView = new StudentView();
            teacherView = new TeacherView();
        }

        public void dispatch(String request) {
            if (request.equalsIgnoreCase("Student")) {
                studentView.display();
            } else {
                teacherView.display();
            }
        }
    }

* Bu sınıfımız görüldüğü üzere 2 obje sınıfımızın **instance**'ını oluşturuyor.
* Burayı yönetecek olan **FrontController** sınıfından gelecek olan isteğe göre _StudentView_ veya _TeacherView_ objelerinin birinin **display** metodunu çalıştırılacak.

3. FrontController sınıfızımı ekleyelim.
&NewLine;
FrontController

    class FrontController {
        private Dispatching Dispatching;

        public FrontController() {
            Dispatching = new Dispatching();
        }

        private boolean isAuthenticUser() {
            System.out.println("Authentication successful.");
            return true;
        }

        private void trackRequest(String request) {
            System.out.println("Requested View: " + request);
        }

        public void dispatchRequest(String request) {
            trackRequest(request);

            if (isAuthenticUser()) {
                Dispatching.dispatch(request);
            }
        }
    }

* Bu sınıfımız mainden gelen istekleri karşılayacak olan sınıftır.
* Dispatching sınıfının instance'ı burada oluşturulmuştur.
* Gelen her istek için istenildiği gibi çalışan farklı metodlar burada **dispatchRequest()** sınıfının içinde çağırılabilir.

4. Son olarak main metodumuz ile uygulamamızı çalıştıralım.
&NewLine;
FrontControllerPattern

    class FrontControllerPattern
    {
        public static void main(String[] args)
        {
            FrontController frontController = new FrontController();
            frontController.dispatchRequest("Teacher");
            frontController.dispatchRequest("Student");
        }
    }

* Main metodumuz içinden sadece FrontController instance'ını oluştururuz ve içine bir parametre vererek **dispatchRequest()** metodunu çalıştırırız.
* Bu metod FrontController sınıfında yer alır. Gelen her istekte çalıştırılmak istenilen fonksiyonlar var ise bu metod içerisinde çağrılır.
* Gelen parametre **isAuthenticUser()** kontrole de tabi tutulabilir. Böylelikle sadece izin verilen işlemlerde çalıştırılabilir.
* Eğer izini var ise _Dispatching_ sınıfının **dispatch(request)** metodu çalıştırılır.
* Bu metod sadece parametreye göre hangi objenin hangi fonksiyonu çalışacak ise çalıştırır ve istek sonuca vardırılır.
* Böylelikle gelen istekler önce FrontController tarafından karşılanmış, ardından buradan gerekli sınıflara dağıtımı yapılmış olur.


### Kaynaklar
- https://metinalniacik.medium.com/front-controller-design-pattern-tasar%C4%B1m-%C3%B6r%C3%BCnt%C3%BCs%C3%BC-7d0f57f41e18

- https://www.geeksforgeeks.org/front-controller-design-pattern/