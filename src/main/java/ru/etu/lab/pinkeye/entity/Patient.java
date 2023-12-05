package ru.etu.lab.pinkeye.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

import java.util.Random;

import org.springframework.hateoas.RepresentationModel;


@Getter
@Setter
@ToString
public class Patient extends RepresentationModel<Patient>
{
    private static int cur_number = 0;
    private static ArrayList<String> pathogen_list = get_pathogen_list();
    private static ArrayList<String> cause_list = get_cause_list();
    private static ArrayList<String> symptoms_list = get_symptoms_list();
    private static ArrayList<String> complications_list = get_complications_list();


    private Integer id;
    private Integer temp; // температура тела = temp/10
    private String pathogen; // возбудитель
    private String cause; // причина
    private String symptoms; // симптомы
    private Integer kind; // вид
                            // 1 - бактериальный, 2 - вирусный, 3 - аллергический, 4 - дистрофический, -1 - другое
    private Integer course; // течение
                            // 1 - острое, 2 - хроническое, -1 - другое
    private String complications; // осложнения

    public static Patient genPatient()
    {
        Random r = new Random();
        Patient p = new Patient();
        p.id = Patient.cur_number+1;
        Patient.cur_number++;

        p.course = r.nextInt(2)+1;
        if(r.nextInt(100) > 95)
            p.course = -1;

        p.temp = 366;
        if(r.nextInt(100) > 90)
        {
            int diff = -3 + r.nextInt(28);
            p.temp = p.temp + diff;
        }

        p.kind = r.nextInt(4)+1;
        if(r.nextInt(100) > 97)
            p.kind = -1;

        p.pathogen = get_sub(Patient.pathogen_list, 1);
        p.cause = get_sub(Patient.cause_list, 3);
        p.symptoms = get_sub(Patient.symptoms_list, 3);
        p.complications = get_sub(Patient.complications_list, 0);

        return p;
    }


































    private static String get_sub(List<String> arrrrr, int mid_start)
    {
        Random r = new Random();
        List<Integer> is = new ArrayList<Integer>();
        for(int i = 0; i < arrrrr.size(); i++)
            is.add(i);

        Collections.shuffle(is);

        int randomSeriesLength = mid_start;
        int roll = r.nextInt(100);
        if(roll < 10)
            roll = 3;
        else if (roll < 40)
            roll = 2;
        else if(roll < 80)
            roll = 1;
        else
            roll = 0;
        randomSeriesLength += r.nextBoolean()?roll:-roll;
        if(randomSeriesLength < 0)
            randomSeriesLength = 0;
        if(randomSeriesLength > arrrrr.size())
            randomSeriesLength = arrrrr.size();

        List<Integer> randomSeries = is.subList(0, randomSeriesLength);
        String res = "";
        for(int i = 0; i < randomSeries.size(); i++)
        {
            int cur_i = randomSeries.get(i);
            String buffS = arrrrr.get(cur_i);
            res += buffS;
            if(i < randomSeries.size()-1)
                res += ", ";
        }
        return res;
    }

    private static ArrayList<String> get_pathogen_list()
    {
        ArrayList<String> a = new ArrayList<String>();
        a.add("вирус");
        a.add("бактерия");
        a.add("стафилококк");
        a.add("стрептококк");
        a.add("гемофильная палочка");
        a.add("пневмококк");
        a.add("гонококк");
        a.add("дифтерийная палочка");
        a.add("хламидии");
        a.add("аденовирусы");
        a.add("актиномицеты");
        a.add("аспергиллы");
        return a;
    }

    private static ArrayList<String> get_cause_list()
    {
        ArrayList<String> a = new ArrayList<String>();
        a.add("иммунодефицитные состояния");
        a.add("хроническая инфекция");
        a.add("гайморит");
        a.add("ангина");
        a.add("ринит");
        a.add("фарингит");
        a.add("бронхит");
        a.add("ОРЗ");
        a.add("несоблюдение правил гигиены");
        a.add("неправильный уход за контактными линзами");
        a.add("некачественная косметика");
        a.add("другие заболевания глаз");
        a.add("синдром сухого глаза");
        a.add("воспаление век");
        a.add("анатомические аномалии поверхности глаза");
        a.add("анатомические аномалии поверхности век");
        a.add("недавняя операция на глазах");
        a.add("травма");
        a.add("контактные линзы");
        return a;
    }

    private static ArrayList<String> get_symptoms_list()
    {
        ArrayList<String> a = new ArrayList<String>();
        a.add("покраснение");
        a.add("слезотечение");
        a.add("помутнение");
        a.add("водянистое отделяемое");
        a.add("слизистое отделяемое");
        a.add("гнойное отделяемое");
        a.add("боль в глазу");
        a.add("светобоязнь");
        a.add("спазм век");
        a.add("жжение");
        a.add("опухание век");
        a.add("плёнка из фибрина");
        a.add("воспаления роговицы глаза");
        a.add("ощущение присутствия инородного тела в глазу");
        return a;
    }

    private static ArrayList<String> get_complications_list()
    {
        ArrayList<String> a = new ArrayList<String>();
        a.add("кератит");
        a.add("блефарит");
        a.add("рубцовые изменения");
        a.add("воспаление более глубоких структур");
        a.add("язва роговицы");
        a.add("хориоретинит");
        a.add("синдром сухого глаза");
        return a;
    }
}



/*
Возбудитель:
    стафилококк;
    стрептококк;
    гемофильная палочка;
    пневмококк;
    гонококк;
    дифтерийная палочка;
    хламидии;
    вирусы (например, аденовирусы);
    грибы (актиномицеты, аспергиллы).

Причина:
    иммунодефицитные состояния;
    хронические инфекции — гайморит, ангина, ринит, фарингит, бронхит, ОРЗ;
    несоблюдение правил гигиены и неправильный уход за контактными линзами;
    некачественная косметика;
    другие заболевания глаз — синдром сухого глаза, воспаление век, анатомические аномалии поверхности глаза и век;
    недавняя операция на глазах;
    травма;
    контактные линзы.

Симптомы:
    покраснение;
    слезотечение;
    помутнение;
    водянистое отделяемое;
    слизистое отделяемое;
    гнойное отделяемое;
    боль в глазу;
    светобоязнь;
    спазм век;
    жжение;
    опухание век;
    плёнка из фибрина;
    воспаления роговицы глаза;
    ощущение присутствия инородного тела в глазу (засарённость граз).

Вид:
    бактериальный;
    вирусный;
    грибковый;
    аллергический;
    дистрофический.

Течение:
    острый;
    хронический.

Этап протекания:
    первый;
    второй;
    третий;
    четвёртый;
    пятый.

Осложнение:
    кератит (воспаление роговицы);
    блефарит (воспаление век);
    рубцовые изменения;
    воспаление более глубоких структур (например, сосудистой оболочки);
    язва роговицы;
    хориоретинит;
    синдром сухого глаза.

*/