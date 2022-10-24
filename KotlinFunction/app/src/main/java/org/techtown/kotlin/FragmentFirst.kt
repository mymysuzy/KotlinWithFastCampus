package org.techtown.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentFirst : Fragment() {
    // onCreateView -> 이 파일과 first_fragment.xml이 서로 쌍이라는 것을 알려주는 사이클
    // onCreateView에서 반환하는 View가 이 Fragement의 view가 되는 것
    
    // inflater -> xml이 사용자 눈에 보일 수 있게끔 화면에 사용할 준비를 해준다(즉, xml을 view로 만들어준다)
    // container -> Fragment에서 사용될 xml의 부모뷰
    // savedInstanceState -> Bundle의 형태로 기록을 남긴다
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // root -> 최상위 부모. 가장 왼쪽 벽쪽에 붙어있는 태그
        // attachToRoot : 루트 뷰에 붙일지 말지

        // xml이용해서 Fragment를 Activity에 붙이는 작업
        return inflater.inflate(R.layout.first_fragment, container, false )
    }
}