package com.java.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupByExamples {

    public static void main(String[] args) {

        List<BlogPost> posts = new ArrayList<>();

        BlogPost post1 = new BlogPost("Mumbai", "John", BlogPostType.GUIDE, 5);
        BlogPost post2 = new BlogPost("Pune", "William", BlogPostType.NEWS, 7);
        BlogPost post3 = new BlogPost("Solapur", "Kevin", BlogPostType.REVIEW, 9);
        BlogPost post4 = new BlogPost("Chennai", "Michael", BlogPostType.GUIDE, 2);
        BlogPost post5 = new BlogPost("Hyderabad", "Abecca", BlogPostType.NEWS, 11);

        posts = Arrays.asList(post1, post2, post3, post4, post5);

        int task = 1;

        switch (task) {
            case 1:
                //print all blogposts
                printAllBlogPosts(posts);
                break;


            default:
                printAllBlogPosts(posts);
        }
    }

    private static void printAllBlogPosts(List<BlogPost> posts) {
        posts.forEach(System.out::println);
    }

}
