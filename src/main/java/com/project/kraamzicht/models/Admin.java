    package com.project.kraamzicht.models;



    import com.project.kraamzicht.models.Client;
    import jakarta.persistence.OneToMany;
    import jakarta.persistence.*;
    import java.util.List;


    @Entity
    @Table(name = "admins")
    @PrimaryKeyJoinColumn(name = "username")
    @DiscriminatorValue("Admin")
    public class Admin extends User {

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false, unique = true)
        private long personnelNumber;

        @OneToMany
        private List<MaternityNurse> createdMaternityNurses;

        @OneToMany
        private List<Client> createdClients;

        @OneToMany
        private List<ClientFile> createdClientFiles;

        @OneToMany
        private List<Midwife> createdMidwives;
        public long getPersonnelNumber() {
            return personnelNumber;
        }

        public void setPersonnelNumber(long personnelNumber) {
            this.personnelNumber = personnelNumber;
        }

        public List<MaternityNurse> getCreatedMaternityNurses() {
            return createdMaternityNurses;
        }

        public void setCreatedMaternityNurses(List<MaternityNurse> createdMaternityNurses) {
            this.createdMaternityNurses = createdMaternityNurses;
        }

        public List<Client> getCreatedClients() {
            return createdClients;
        }

        public void setCreatedClients(List<Client> createdClients) {
            this.createdClients = createdClients;
        }

        public List<Midwife> getCreatedMidwives() {
            return createdMidwives;
        }

        public void setCreatedMidwives(List<Midwife> createdMidwives) {
            this.createdMidwives = createdMidwives;
        }

        public List<ClientFile> getCreatedClientFiles() {
            return createdClientFiles;
        }

        public void setCreatedClientFiles(List<ClientFile> createdClientFiles) {
            this.createdClientFiles = createdClientFiles;
        }

    }
