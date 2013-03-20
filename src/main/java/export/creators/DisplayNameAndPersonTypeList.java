package export.creators;

import cablelabs.md.xsd.core._3.PersonType;

import java.util.ArrayList;
import java.util.List;

class DisplayNameAndPersonTypeList {

    static DisplayNameAndPersonTypeList EMPTY = new DisplayNameAndPersonTypeList(null,new ArrayList<PersonType>());

    public String displayName;
    public List<PersonType> personTypeList;

    DisplayNameAndPersonTypeList(String displayName, List<PersonType> personTypeList) {
        this.displayName = displayName;
        this.personTypeList = personTypeList;
    }

    public List<String> getNameList() {
        List<String> retval = new ArrayList<String>();
        for (PersonType personType : personTypeList) {
            retval.add(personType.getFullName());
        }
        return retval;
    }
}
