class Solution {
public:
    string pushDominoes(string dominoes) {
        stringstream stm;
        int fptr = 0;
        int lptr = 0;
        if(dominoes[0] == 'L'){
            stm << 'L';
            fptr++;
        }
        while(++lptr < dominoes.size()){
            //cout << "fptr = " << fptr << ", lptr = " << lptr << endl;
            if(dominoes[lptr] == 'L'){
                if(dominoes[fptr] == 'R'){
                    //cout << "lptr-fptr = " << lptr-fptr << endl;
                    if((lptr-fptr) % 2 == 0){
                        for(int i = 0, t = (lptr-fptr) / 2; i < t; i++, fptr++){
                            stm << 'R';
                        }
                        stm << '.';
                        for(fptr++; fptr <= lptr; fptr++){
                            stm << 'L';
                        }
                    }
                    else{
                        for(int i = 0, t = (lptr-fptr+1) / 2; i < t; i++, fptr++){
                            stm << 'R';
                        }
                        for(; fptr <= lptr; fptr++){
                            stm << 'L';
                        }
                    }
                }
                else{
                    for(; fptr <= lptr; fptr++){
                        stm << 'L';
                    }
                }
            }
            else if(dominoes[lptr] == 'R'){
                if(dominoes[fptr] == 'R'){
                    for(; fptr < lptr; fptr++){
                        stm << 'R';
                    }
                }
                else{
                    for(; fptr < lptr; fptr++){
                        stm << '.';
                    }
                }
            }
        }
        if(fptr < lptr){
            if(dominoes[fptr] == 'R'){
                for(; fptr < lptr; fptr++){
                    stm << 'R';
                }
            }
            else{
                for(; fptr < lptr; fptr++){
                    stm << '.';
                }
            }
        }
        return stm.str();
    }
};