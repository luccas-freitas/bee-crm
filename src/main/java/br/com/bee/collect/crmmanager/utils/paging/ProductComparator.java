package br.com.bee.collect.crmmanager.utils.paging;

import br.com.bee.collect.crmmanager.model.Product;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ProductComparator {
    @EqualsAndHashCode
    @AllArgsConstructor
    @Getter
    static class Key {
        String name;
        Direction dir;
    }

    static Map<Key, Comparator<Product>> map = new HashMap<>();

    static {
        map.put(new Key("name", Direction.asc), Comparator.comparing(Product::getName));
        map.put(new Key("name", Direction.desc), Comparator.comparing(Product::getName)
                .reversed());

        map.put(new Key("description", Direction.asc), Comparator.comparing(Product::getDescription));
        map.put(new Key("description", Direction.desc), Comparator.comparing(Product::getDescription)
                .reversed());

        map.put(new Key("quantity", Direction.asc), Comparator.comparing(Product::getQuantity));
        map.put(new Key("quantity", Direction.desc), Comparator.comparing(Product::getQuantity)
                .reversed());

        map.put(new Key("unity", Direction.asc), Comparator.comparing(Product::getUnity));
        map.put(new Key("unity", Direction.desc), Comparator.comparing(Product::getUnity)
                .reversed());

        map.put(new Key("updated_at", Direction.asc), Comparator.comparing(Product::getUpdatedAt));
        map.put(new Key("updated_at", Direction.desc), Comparator.comparing(Product::getUpdatedAt)
                .reversed());
    }

    public static Comparator<Product> getComparator(String name, Direction dir) {
        return map.get(new Key(name, dir));
    }

    private ProductComparator() {
    }
}