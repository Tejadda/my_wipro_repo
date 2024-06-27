// Render policy list
const policyList = [
    { id: 1, name: 'Policy 1', category: 'Category 1', status: 'Active' },
    { id: 2, name: 'Policy 2', category: 'Category 2', status: 'Inactive' },
    { id: 3, name: 'Policy 3', category: 'Category 3', status: 'Active' },
    { id: 4, name: 'Policy 4', category: 'Category 1', status: 'Inactive' },
    { id: 5, name: 'Policy 5', category: 'Category 2', status: 'Active' },
    //...
];

const activePolicies = policyList.filter((policy) => policy.status === 'Active');
const inactivePolicies = policyList.filter((policy) => policy.status === 'Inactive');

const policyTableBody = document.getElementById('policy-list');
policyList.forEach((policy) => {
    const row = document.createElement('tr');
    row.innerHTML = `
        <td>${policy.id}</td>
        <td>${policy.name}</td>
        <td>${policy.category}</td>
        <td>${policy.status}</td>
        <td>
            <button class="btn btn-primary" data-toggle="modal" data-target="#policy-modal" data-policy-id="${policy.id}">View</button>
            <button class="btn btn-success" data-toggle="modal" data-target="#edit-policy-modal" data-policy-id="${policy.id}">Edit</button>
            <button class="btn btn-danger" data-toggle="modal" data-target="#delete-policy-modal" data-policy-id="${policy.id}">Delete</button>
        </td>
    `;
    policyTableBody.appendChild(row);
});

const activePolicyTableBody = document.getElementById('active-policy-list');
activePolicies.forEach((policy) => {
    const row = document.createElement('tr');
    row.innerHTML = `
        <td>${policy.id}</td>
        <td>${policy.name}</td>
        <td>${policy.category}</td>
        <td>${policy.status}</td>
        <td>
            <button class="btn btn-primary" data-toggle="modal" data-target="#policy-modal" data-policy-id="${policy.id}">View</button>
            <button class="btn btn-success" data-toggle="modal" data-target="#edit-policy-modal" data-policy-id="${policy.id}">Edit</button>
            <button class="btn btn-danger" data-toggle="modal" data-target="#delete-policy-modal" data-policy-id="${policy.id}">Delete</button>
        </td>
    `;
    activePolicyTableBody.appendChild(row);
});

const inactivePolicyTableBody = document.getElementById('inactive-policy-list');
inactivePolicies.forEach((policy) => {
    const row = document.createElement('tr');
    row.innerHTML = `
        <td>${policy.id}</td>
        <td>${policy.name}</td>
        <td>${policy.category}</td>
        <td>${policy.status}</td>
        <td>
            <button class="btn btn-primary" data-toggle="modal" data-target="#policy-modal" data-policy-id="${policy.id}">View</button>
            <button class="btn btn-success" data-toggle="modal" data-target="#edit-policy-modal" data-policy-id="${policy.id}">Edit</button>
            <button class="btn btn-danger" data-toggle="modal" data-target="#delete-policy-modal" data-policy-id="${policy.id}">Delete</button>
        </td>
    `;
    inactivePolicyTableBody.appendChild(row);
});