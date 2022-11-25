package org.example;

import org.example.dtos.Entry;

import java.util.List;
import java.util.stream.Collectors;

public class RestFulApi {


    public static void main(String[] args) throws Exception {
        List<Entry> entriesArrayList = EntriesApi.callEntriesAPiAndGetListOfEntries();

        List<Entry> authenticationAndAuthorizationList = entriesArrayList.stream().filter(entry->entry.getCategory().equals("Authentication & Authorization")).collect(Collectors.toList());
        authenticationAndAuthorizationList.stream().forEach(Entry::printEntry);

    }

}
