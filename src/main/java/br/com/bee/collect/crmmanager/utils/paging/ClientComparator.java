package br.com.bee.collect.crmmanager.utils.paging;

import br.com.bee.collect.crmmanager.model.Client;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ClientComparator {
    @EqualsAndHashCode
    @AllArgsConstructor
    @Getter
    static class Key {
        String name;
        Direction dir;
    }

    static Map<Key, Comparator<Client>> map = new HashMap<>();

    static {
        map.put(new Key("name", Direction.asc), Comparator.comparing(Client::getName));
        map.put(new Key("name", Direction.desc), Comparator.comparing(Client::getName)
                .reversed());

        map.put(new Key("document", Direction.asc), Comparator.comparing(Client::getDocument));
        map.put(new Key("document", Direction.desc), Comparator.comparing(Client::getDocument)
                .reversed());

        map.put(new Key("address", Direction.asc), Comparator.comparing(Client::getAddress));
        map.put(new Key("address", Direction.desc), Comparator.comparing(Client::getAddress)
                .reversed());

        map.put(new Key("phone", Direction.asc), Comparator.comparing(Client::getPhone));
        map.put(new Key("phone", Direction.desc), Comparator.comparing(Client::getPhone)
                .reversed());
    }

    public static Comparator<Client> getComparator(String name, Direction dir) {
        return map.get(new Key(name, dir));
    }

    private ClientComparator() {
    }
}