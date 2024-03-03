package com.chatserver.chat;

import java.util.ArrayList;
import java.util.Collection;

public class Distributor {
    private Collection<Issuer> issuers = new ArrayList<Issuer>();

    public void addIssuer(Issuer issuer) {
        this.issuers.add(issuer);
    }

    public void deliveryMessage(String msg, String uuid) {
        for (Issuer issuer : this.issuers) {
            if (issuer.getUUID() != uuid) {
                issuer.send(msg);
            }
        }
    }
}
