    package com.project.kraamzicht.models;



    import jakarta.persistence.*;
    import java.util.List;
    import java.util.Set;

    @Entity
    @Table(name = "admins")
    public class Admin extends User {

        @GeneratedValue
        @Column(nullable = false, unique = true)
        private long personnelNumber;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "username")
        private UserEntity userEntity;



//        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//        private List<MaternityNurse> createdMaternityNurses;
//
//        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//        private List<Client> createdClients;
//
//        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//        private List<ClientFile> createdClientFiles;
//
//        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//        private List<Midwife> createdMidwives;

//        @ManyToMany(cascade = CascadeType.ALL)
//        @JoinTable(
//                name = "admin_authority",
//                joinColumns = @JoinColumn(name = "admin_username"),
//                inverseJoinColumns = {
//                        @JoinColumn(name = "authority_username", referencedColumnName = "username"),
//                        @JoinColumn(name = "authority_name", referencedColumnName = "authority")
//                }
//        )
//        private Set<Authority> authorities;

        public UserEntity getUserEntity() {
            return userEntity;
        }

        public void setUserEntity(UserEntity userEntity) {
            this.userEntity = userEntity;
        }

//        public void setUserEntity(UserEntity userEntity) {
//            this.userEntity = userEntity;
//            userEntity.setAdmin(this);
//        }

        public long getPersonnelNumber() {
            return personnelNumber;
        }

        public void setPersonnelNumber(long personnelNumber) {
            this.personnelNumber = personnelNumber;
        }

//        public List<MaternityNurse> getCreatedMaternityNurses() {
//            return createdMaternityNurses;
//        }
//
//        public void setCreatedMaternityNurses(List<MaternityNurse> createdMaternityNurses) {
//            this.createdMaternityNurses = createdMaternityNurses;
//        }
//
//        public List<Client> getCreatedClients() {
//            return createdClients;
//        }
//
//        public void setCreatedClients(List<Client> createdClients) {
//            this.createdClients = createdClients;
//        }
//
//        public List<Midwife> getCreatedMidwives() {
//            return createdMidwives;
//        }
//
//        public void setCreatedMidwives(List<Midwife> createdMidwives) {
//            this.createdMidwives = createdMidwives;
//        }
//
//        public List<ClientFile> getCreatedClientFiles() {
//            return createdClientFiles;
//        }
//
//        public void setCreatedClientFiles(List<ClientFile> createdClientFiles) {
//            this.createdClientFiles = createdClientFiles;
//        }



//        public void copyToUserEntity(UserEntity userEntity) {
//            userEntity.setUsername(this.getUsername());
//            userEntity.setPassword(this.getPassword());
//            userEntity.setAuthority(this.getAuthority());
//            userEntity.setName(this.getName());
//            userEntity.setSurname(this.getSurname());
//            userEntity.setDob(this.getDob());
//            userEntity.setAddress(this.getAddress());
//            userEntity.setPostalcode(this.getPostalcode());
//            userEntity.setPlace(this.getPlace());
//            userEntity.setPhoneNr(this.getPhoneNr());
//            userEntity.setEmail(this.getEmail());
//            userEntity.setRole(this.getRole());
//            userEntity.setEnabled(this.isEnabled());
//            userEntity.setApikey(this.getApikey());
        }

//        public UserEntity toUserEntity() {
//            UserEntity userEntity = new UserEntity();
//            copyToUserEntity(userEntity); // Gebruik de bestaande methode om gegevens te kopiëren
//            return userEntity;
//        }


