package filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import timetable.Timetable;
import timetable.Session;


public class InstructorFilter extends Filter {

    // filter out the timetables with unwanted timetables

    public InstructorFilter(ArrayList<Timetable> input, ArrayList<String> unwanted) {
        super(input, unwanted);
    }

    @Override
    public ArrayList<Timetable> sort() {

        for (Timetable singleTimetable : this.input) {

            HashMap<String, Session> table = singleTimetable.timeTable;

            Collection<Session> values = table.values();

            boolean tag = true;
            for (Session session : values) {
                if (this.unwanted.contains(session.instructor)) {
                    tag = false;
                    break;
                }
            }
            if (tag) {
                this.output.add(singleTimetable);
            }
        }
        return this.output;
    }
}


//        for (Timetable singleTimetable : this.input) {                // loop every timetable
//            // get the data of timetable in hashmap form.
//            HashMap<String, Session> mapTimetable = singleTimetable.timeTable;
//
//            // get the keys of mapTimetable
//            Set<String> keys = mapTimetable.keySet();
//
//            // get the size of sessions
//            int size = 0;
//            for (String key : keys) {
//                if (mapTimetable.get(key) != null) {
//                    size++;
//                }
//            }
//
//            int checker = 0;           // used to check
//
//            for (String key : keys) {
//
//                if (!this.unwanted.contains(mapTimetable.get(key).instructor)) {
//                    checker += 1;
//                }
//                if (size == checker) {
//                    this.output.add(singleTimetable);
//                }
//            }
//        }
//    return this.output;
//    }
//}


