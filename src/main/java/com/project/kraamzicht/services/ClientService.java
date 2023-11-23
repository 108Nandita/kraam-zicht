package com.project.kraamzicht.services;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public boolean isClientOwner(String username, String clientId) {
        // Voeg hier de logica toe om te controleren of de gebruiker de eigenaar is van de client met het opgegeven clientId
        // Return true als de gebruiker de eigenaar is, anders false
        return true; // Hier moet je je eigen logica implementeren
    }
}