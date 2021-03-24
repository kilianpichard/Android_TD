package com.example.td1.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.td1.R;

public class ListFragment extends Fragment {

    private ListViewModel listViewModel;

<<<<<<< Updated upstream:app/src/main/java/com/example/td1/ui/list/ListFragment.java
        View root = inflater.inflate(R.layout.fragment_list, container, false);
=======
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

>>>>>>> Stashed changes:app/src/main/java/com/example/td1/ui/gallery/GalleryFragment.java
        return root;
    }

}