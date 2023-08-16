package MainModules.ProcessingModules;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MovieSearch {
    public void search() {

        class Movie {
            private final String name;
            private final String url;

            public Movie(String name, String url) {
                this.name = name;
                this.url = url;
            }

            public String getName() {
                return name;
            }

            public String getUrl() {
                return url;
            }
        }


        Map<String, List<Movie>> moviesByCategory = new HashMap<>();
        List<Movie> actionMovies = new ArrayList<>();
        actionMovies.add(new Movie("Форсаж", "https://www.imdb.com/title/tt0232500/"));
        actionMovies.add(new Movie("Мстители", "https://www.imdb.com/title/tt0848228/"));
        actionMovies.add(new Movie("Стражи галактики: Часть 3", "https://www.imdb.com/title/tt6791350/"));
        actionMovies.add(new Movie("Быстрее пули", "https://www.imdb.com/title/tt12593682/"));
        actionMovies.add(new Movie("Никто", "https://www.imdb.com/title/tt7888964/"));


        List<Movie> dramaMovies = new ArrayList<>();
        dramaMovies.add(new Movie("Побег из Шоушенка", "https://www.imdb.com/title/tt0111161/"));
        dramaMovies.add(new Movie("Ла Ла Ленд", "https://www.imdb.com/title/tt3783958/"));
        dramaMovies.add(new Movie("Дом, который построил Джек", "https://www.imdb.com/title/tt4003440/"));
        dramaMovies.add(new Movie("Прибытие", "https://www.imdb.com/title/tt2543164/"));
        dramaMovies.add(new Movie("Паразиты", "https://www.imdb.com/title/tt6751668/"));


        List<Movie> comedyMovies = new ArrayList<>();
        comedyMovies.add(new Movie("Начало", "https://www.imdb.com/title/tt1375666/"));
        comedyMovies.add(new Movie("1+1", "https://www.imdb.com/title/tt1675434/"));
        comedyMovies.add(new Movie("Холоп", "https://www.imdb.com/video/vi2368062233/?playlistId=tt11418452&"));
        comedyMovies.add(new Movie("Начало", "https://www.imdb.com/title/tt1375666/"));
        comedyMovies.add(new Movie("Один дома", "https://www.imdb.com/title/tt0099785/"));







        moviesByCategory.put("Боевик", actionMovies);
        moviesByCategory.put("Драма", dramaMovies);
        moviesByCategory.put("Комедия", comedyMovies);


        System.out.println("Доступные категории фильмов:");
        for (String category : moviesByCategory.keySet()) {
            System.out.println(category);
        }


        System.out.print("\nВведите название категории фильмов: ");
        Scanner scanner = new Scanner(System.in);
        String selectedCategory = scanner.nextLine();


        if (!moviesByCategory.containsKey(selectedCategory)) {
            System.out.println("Категория не найдена");
        } else {

            List<Movie> movies = moviesByCategory.get(selectedCategory);
            System.out.println("\nФильмы в категории " + selectedCategory + ":");
            for (int i = 0; i < 5 && i < movies.size(); i++) {
                Movie movie = movies.get(i);
                System.out.println((i+1) + ". " + movie.getName());
            }


            System.out.print("\nВведите номер фильма для открытия ссылки: ");
            int selectedMovieIndex = scanner.nextInt();


            if (selectedMovieIndex <= 0 || selectedMovieIndex > movies.size()) {
                System.out.println("Неправильный номер фильма");
            } else {

                try {
                    Movie selectedMovie = movies.get(selectedMovieIndex - 1);
                    Desktop.getDesktop().browse(new URI(selectedMovie.getUrl()));
                } catch (IOException | URISyntaxException e) {
                    System.out.println("Ошибка при открытии ссылки");
                }
            }
        }

        scanner.close();
    }
}
