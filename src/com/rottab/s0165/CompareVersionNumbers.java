package com.rottab.s0165;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    public int compareVersion1(String version1, String version2) {
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
        assertThat(compareVersion1("3.0002.1", "1.2.3")).isEqualTo(1);
        assertThat(compareVersion1("1.1.3", "1.1.4")).isEqualTo(-1);
        assertThat(compareVersion1("1.001.1", "1.1.1")).isEqualTo(0);
        assertThat(compareVersion1("1.0", "1")).isEqualTo(0);
        assertThat(compareVersion1("3.0.4.10", "3.0.4.2")).isEqualTo(1);
        assertThat(compareVersion1("3.0.4.10.1.2.3.5.1", "3.0.4.2")).isEqualTo(1);
        assertThat(compareVersion1("3", "3.0.4")).isEqualTo(-1);
    }


    public int compareVersion2(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < Integer.min(v1.length, v2.length); i++) {
            int i1 = Integer.parseInt(v1[i]);
            int i2 = Integer.parseInt(v2[i]);
            if (i1 > i2) return 1;
            else if (i1 < i2) return -1;
        }
        if (v1.length > v2.length) {
            for (int i = v2.length; i < v1.length; i++) if (Integer.parseInt(v1[i]) > 0) return 1;
        } else {
            for (int i = v1.length; i < v2.length; i++) if (Integer.parseInt(v2[i]) > 0) return -1;
        }
        return 0;
    }


    @Test
    public void test2() {
        assertThat(compareVersion2("3.0002.1", "1.2.3")).isEqualTo(1);
        assertThat(compareVersion2("1.1.3", "1.1.4")).isEqualTo(-1);
        assertThat(compareVersion2("1.001.1", "1.1.1")).isEqualTo(0);
        assertThat(compareVersion2("1.0", "1")).isEqualTo(0);
        assertThat(compareVersion2("3.0.4.10", "3.0.4.2")).isEqualTo(1);
        assertThat(compareVersion2("3.0.4.10.1.2.3.5.1", "3.0.4.2")).isEqualTo(1);
        assertThat(compareVersion2("3", "3.0.4")).isEqualTo(-1);
    }
}
