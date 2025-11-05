package week09.kristian.umn.ac.id;

public class Assignment {

    static interface Power {
        void turnOn();
        void turnOff();
    }

    static interface VolumeControl {
        void increaseVolume(int level);
        void decreaseVolume(int level);
    }

    static class Device {
        String brand;
        String model;

        interface Connectivity {
            void connectToWiFi(String networkName);
            void disconnectFromWiFi();
        }

        public Device(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        public void displayInfo() {
            System.out.println("Device Info: Brand: " + this.brand + ", Model: " + this.model);
        }
    }

    static class SmartPhone extends Device implements Power, VolumeControl, Device.Connectivity {

        int currentVolume;
        String connectedNetwork;

        public SmartPhone(String brand, String model) {
            super(brand, model);
            this.currentVolume = 20;
            this.connectedNetwork = null;
        }

        @Override
        public void turnOn() {
            System.out.println("Turning on the device...");
        }

        @Override
        public void turnOff() {
            System.out.println("Turning off the device...");
        }

        @Override
        public void increaseVolume(int level) {
            this.currentVolume += level;
            System.out.println("Increasing volume by " + level + " levels.");
        }

        @Override
        public void decreaseVolume(int level) {
            this.currentVolume -= level;
            System.out.println("Decreasing volume by " + level + " levels.");
        }

        @Override
        public void connectToWiFi(String networkName) {
            this.connectedNetwork = networkName;
            System.out.println("Connecting to WiFi: " + networkName);
        }

        @Override
        public void disconnectFromWiFi() {
            this.connectedNetwork = null;
            System.out.println("Disconnecting from WiFi...");
        }
    }

    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("Samsung", "Galaxy S21");

        myPhone.displayInfo();
        myPhone.turnOn();
        myPhone.increaseVolume(5);
        myPhone.decreaseVolume(3);
        myPhone.connectToWiFi("HomeNetwork");
        myPhone.disconnectFromWiFi();
        myPhone.turnOff();
    }
}
