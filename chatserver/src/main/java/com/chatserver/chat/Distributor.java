package com.chatserver.chat;

import java.util.ArrayList;
import java.util.Collection;

public class Distributor {
    private Collection<Issuer> issuers = new ArrayList<Issuer>();

    public void addIssuer(Issuer issuer) {
        this.issuers.add(issuer);
    }

    public void deliveryMessage(String msg) {
        for (Issuer issuer : this.issuers) {
            issuer.send(msg);
        }
    }
}
