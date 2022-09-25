package jobsheet2.polinema.ac.id.a04androidrecyclerviewrara;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    private ArrayList<Word> dataList;

    public WordAdapter(ArrayList<Word> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public WordAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.WordViewHolder wordViewHolder, int i) {
        wordViewHolder.word.setText(dataList.get(i).getWord());
        wordViewHolder.num.setText(dataList.get(i).getNo());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        private TextView word, num;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            word = (TextView) itemView.findViewById(R.id.word);
            num = (TextView) itemView.findViewById(R.id.nomor);
        }
    }

}
