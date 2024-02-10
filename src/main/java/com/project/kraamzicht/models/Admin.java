    package com.project.kraamzicht.models;

    import jakarta.persistence.*;

    @Entity
    @Table(name = "admins")
    public class Admin extends User {
        @GeneratedValue
        @Column(nullable = false, unique = true)
        private long personnelNumber;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "username")
        private UserEntity userEntity;

        public UserEntity getUserEntity() {
            return userEntity;
        }

        public void setUserEntity(UserEntity userEntity) {
            this.userEntity = userEntity;
        }

        public long getPersonnelNumber() {
            return personnelNumber;
        }

        public void setPersonnelNumber(long personnelNumber) {
            this.personnelNumber = personnelNumber;
        }

    }

