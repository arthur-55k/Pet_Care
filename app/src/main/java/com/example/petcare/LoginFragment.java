package com.example.petcare;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.petcare.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.etEmail.getText() != null ? binding.etEmail.getText().toString().trim() : "";
            String password = binding.etPassword.getText() != null ? binding.etPassword.getText().toString().trim() : "";

            if (TextUtils.isEmpty(email)) {
                binding.tilEmail.setError("Por favor, insira o e-mail ou usuário");
                return;
            } else {
                binding.tilEmail.setError(null);
            }

            if (TextUtils.isEmpty(password)) {
                binding.tilPassword.setError("Por favor, insira a senha");
                return;
            } else {
                binding.tilPassword.setError(null);
            }

            // Simulate successful login and navigate to FirstFragment
            Toast.makeText(requireContext(), "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();
            NavHostFragment.findNavController(LoginFragment.this)
                    .navigate(R.id.action_LoginFragment_to_FirstFragment);
        });

        binding.tvForgotPassword.setOnClickListener(v ->
                Toast.makeText(requireContext(), "Funcionalidade de recuperar senha", Toast.LENGTH_SHORT).show()
        );

        binding.tvRegister.setOnClickListener(v ->
                Toast.makeText(requireContext(), "Funcionalidade de cadastro de PetShop", Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
