    package com.project.kraamzicht.models;



    import jakarta.persistence.*;
    import java.util.List;
    import java.util.Set;

    @Entity
    @Table(name = "admins")
    @PrimaryKeyJoinColumn(name = "username")
    @DiscriminatorValue("Admin")
    public class Admin extends User {

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false, unique = true)
        private long personnelNumber;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        private List<MaternityNurse> createdMaternityNurses;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Client> createdClients;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        private List<ClientFile> createdClientFiles;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Midwife> createdMidwives;

        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(
                name = "admin_authority",
                joinColumns = @JoinColumn(name = "admin_username"),
                inverseJoinColumns = {
                        @JoinColumn(name = "authority_username", referencedColumnName = "username"),
                        @JoinColumn(name = "authority_name", referencedColumnName = "authority")
                }
        )
        private Set<Authority> authorities;


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

        public Set<Authority> getAuthorities() {
            return authorities;
        }

        public void setAuthorities(Set<Authority> authorities) {
            this.authorities = authorities;
        }
    }
