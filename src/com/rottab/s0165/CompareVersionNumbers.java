package com.rottab.s0165;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CompareVersionNumbers {

    public List<Integer> getVersion(String version) {
        List<Integer> l = new LinkedList<>();
        Scanner scanner = new Scanner(version);
        for (int i = 0; i < 500; i++) {
            try {
                l.add(scanner.useDelimiter("\\.").nextInt());
            } catch (Exception e) {
                break;
            }
        }
        return l;
    }

    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = getVersion(version1);
        List<Integer> v2 = getVersion(version2);

        for (int i = 0; i < Integer.min(v1.size(), v2.size()); i++) {
            if (v1.get(i) > v2.get(i)) return 1;
            else if (v1.get(i) < v2.get(i)) return -1;
        }
        if (v1.size() > v2.size()) {
            for (int i = v2.size(); i < v1.size(); i++) if (v1.get(i) > 0) return 1;
        } else {
            for (int i = v1.size(); i < v2.size(); i++) if (v2.get(i) > 0) return -1;
        }
        return 0;
    }

    @Test
    public void test() {
        assertThat(compareVersion("3.0002.1", "1.2.3")).isEqualTo(1);
        assertThat(compareVersion("1.1.3", "1.1.4")).isEqualTo(-1);
        assertThat(compareVersion("1.001.1", "1.1.1")).isEqualTo(0);
        assertThat(compareVersion("1.0", "1")).isEqualTo(0);
        assertThat(compareVersion("3.0.4.10", "3.0.4.2")).isEqualTo(1);
        assertThat(compareVersion("3.0.4.10.1.2.3.5.1", "3.0.4.2")).isEqualTo(1);
        assertThat(compareVersion("3", "3.0.4")).isEqualTo(-1);
    }
}
